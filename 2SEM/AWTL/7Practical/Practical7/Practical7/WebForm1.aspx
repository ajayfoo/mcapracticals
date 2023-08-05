<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Practical7.WebForm1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:TextBox ID="IDTxt" runat="server"></asp:TextBox>&nbsp;&nbsp;
        <asp:Button ID="FindIDBtn" runat="server" Text="Find ID" 
            onclick="FindIDBtn_Click" />
        &nbsp;&nbsp;
        <asp:Button ID="AllRecBtn" runat="server" Text="Show Every Record" 
            onclick="AllRecBtn_Click" />
        <br />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False"
            DataKeyNames="id">
            <Columns>
                <asp:BoundField DataField="id" HeaderText="id" ReadOnly="True" SortExpression="id" />
                <asp:BoundField DataField="name" HeaderText="name" SortExpression="name" />
                <asp:CheckBoxField DataField="is_outdoor" HeaderText="is_outdoor" SortExpression="is_outdoor" />
                <asp:BoundField DataField="pcount" HeaderText="pcount" SortExpression="pcount" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:collConnectionString %>"
            SelectCommand="SELECT * FROM [ajayk57_games]"></asp:SqlDataSource>
    </div>
    </form>
</body>
</html>
