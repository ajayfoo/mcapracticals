#include "ns3/animation-interface.h"
#include "ns3/applications-module.h"
#include "ns3/core-module.h"
#include "ns3/internet-module.h"
#include "ns3/log.h"
#include "ns3/mobility-module.h"
#include "ns3/point-to-point-module.h"
#include <cstdint>

using namespace ns3;

int main(int argc, char *argv[]) {
  // look for any command line arguments and act on it
  CommandLine(__FILE__).Parse(argc, argv);

  NS_LOG_COMPONENT_DEFINE("HelloPointToPoint");
  LogComponentEnable("UdpEchoClientApplication", LOG_LEVEL_INFO);
  LogComponentEnable("UdpEchoServerApplication", LOG_LEVEL_INFO);

  // create nodes(computers)
  NodeContainer nodeContainer;
  nodeContainer.Create(2);

  // create net devices and channels internally
  PointToPointHelper p2p;
  p2p.SetDeviceAttribute("DataRate", StringValue("5Mbps"));
  p2p.SetChannelAttribute("Delay", StringValue("2ms"));

  // store net devices for later use
  NetDeviceContainer netDevices = p2p.Install(nodeContainer);

  // install Internet Stack like (UDP, TCP, IP, etc.)

  InternetStackHelper{}.Install(nodeContainer);

  Ipv4AddressHelper ipv4AddHelper;
  ipv4AddHelper.SetBase("192.168.1.0", "255.255.255.0");

  Ipv4InterfaceContainer ipv4InterfaceContainer =
      ipv4AddHelper.Assign(netDevices);

  // setup minimal udp echo client and udp  echo server
  constexpr std::uint32_t UDP_ECHO_SERVER_PORT_NUMBER{57};
  UdpEchoServerHelper udpEchoServerHelper(UDP_ECHO_SERVER_PORT_NUMBER);
  UdpEchoClientHelper udpEchoClientHelper(ipv4InterfaceContainer.GetAddress(1),
                                          UDP_ECHO_SERVER_PORT_NUMBER);

  udpEchoClientHelper.SetAttribute("MaxPackets", UintegerValue(20));
  udpEchoClientHelper.SetAttribute("PacketSize", UintegerValue(1024));
  udpEchoClientHelper.SetAttribute("Interval", TimeValue(Seconds(1)));

  // setup application

  ApplicationContainer udpServerApps =
      udpEchoServerHelper.Install(nodeContainer.Get(1));
  ApplicationContainer udpClientApps =
      udpEchoClientHelper.Install(nodeContainer.Get(0));

  // configure udp client and server

  udpServerApps.Start(Seconds(1.0));
  udpServerApps.Stop(Seconds(20.0));
  udpClientApps.Start(Seconds(2.0));
  udpClientApps.Stop(Seconds(20.0));

  // generate trace file

  MobilityHelper mobility;
  mobility.SetMobilityModel("ns3::ConstantPositionMobilityModel");
  mobility.Install(nodeContainer);

  AnimationInterface{"test.xml"};
  AnimationInterface::SetConstantPosition(nodeContainer.Get(0), 1, 1);
  AnimationInterface::SetConstantPosition(nodeContainer.Get(1), 5, 1);

  Simulator::Run();
  Simulator::Destroy();
  return 0;
}