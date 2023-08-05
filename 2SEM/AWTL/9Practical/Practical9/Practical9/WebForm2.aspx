<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2.aspx.cs" Inherits="Practical9.WebForm2" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:GridView ID="GridView1" runat="server">
        </asp:GridView>
        <br />
        <b>Enter Game Information:-</b><br />
        ID&nbsp;
        <asp:TextBox ID="idTxt" runat="server"></asp:TextBox>
        <br />
        Name&nbsp;
        <asp:TextBox ID="nameTxt" runat="server"></asp:TextBox>
        <br />
        <asp:CheckBox ID="outdoorChkBx" runat="server" Text="Is Outdoor?" />
        <br />
        Player count&nbsp;
        <asp:TextBox ID="pcountTxt" runat="server"></asp:TextBox>
        <br />
        Status&nbsp;
        <asp:Label ID="statusLbl" runat="server">_______</asp:Label>
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Insert" />
    </div>
    </form>
</body>
</html>
