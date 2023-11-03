// SPDX-License-Identifier: MIT

pragma solidity ^0.8.18;
pragma experimental ABIEncoderV2;

contract Electricity {
    struct Consumer {
        uint256 units;
        string name;
        string addr;
        uint256 consumerID;
        uint256 amount;
    }

    Consumer[] public consumers;

    function addConsumerInfo(
        uint256 units,
        string memory name,
        string memory addr,
        uint256 consumerID
    ) public {
        Consumer memory c = Consumer(units, name, addr, consumerID, 0);
        consumers.push(c);
    }

    function calculateBillAmount(uint256 consumerID) public {
        for (uint256 i = 0; i < consumers.length; i++) {
            if (consumers[i].consumerID == consumerID) {
                uint256 units = consumers[i].units;
                uint256 amount = 0;
                uint256 surcharge = 0;

                if (units <= 50) {
                    amount = units * 50; // Rs. 0.50/unit for the first 50 units
                } else {
                    amount = 50 * 50; // Rs. 0.50/unit for the first 50 units

                    units -= 50;

                    if (units <= 100) {
                        amount += units * 75; // Rs. 0.75/unit for the next 100 units
                    } else {
                        amount += 100 * 75; // Rs. 0.75/unit for the next 100 units

                        units -= 100;

                        if (units <= 100) {
                            amount += units * 120; // Rs. 1.20/unit for the next 100 units
                        } else {
                            amount += 100 * 120; // Rs. 1.20/unit for the next 100 units

                            units -= 100;

                            amount += units * 150; // Rs. 1.50/unit for units above 250
                        }
                    }
                }

                surcharge = (amount * 20) / 100;
                amount += surcharge;

                consumers[i].amount = amount;
                return; // Exit the loop once the consumer's bill is calculated.
            }
        }
    }

    function displayConsumerInfo(uint256 consumerID)
        public
        view
        returns (
            uint256,
            string memory,
            string memory,
            uint256,
            uint256
        )
    {
        for (uint256 i = 0; i < consumers.length; i++) {
            Consumer memory c = consumers[i];
            if (c.consumerID == consumerID) {
                return (c.units, c.name, c.addr, c.consumerID, c.amount);
            }
        }
        return (0, "Not Found", "Not Found", 0, 0);
    }

    function displayAllInfo() public view returns (Consumer[] memory) {
        return consumers;
    }
}

