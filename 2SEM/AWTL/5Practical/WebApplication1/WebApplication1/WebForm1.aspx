<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <article>
            <h2>Original Order of table games</h2>
            <asp:GridView ID="GridView1" runat="server" DataSourceID="SqlDataSource1" AutoGenerateColumns="False" DataKeyNames="id">
                <Columns>
                    <asp:BoundField DataField="id" HeaderText="id" ReadOnly="True" SortExpression="id"></asp:BoundField>
                    <asp:BoundField DataField="name" HeaderText="name" SortExpression="name"></asp:BoundField>
                    <asp:CheckBoxField DataField="is_outdoor" HeaderText="is_outdoor" SortExpression="is_outdoor"></asp:CheckBoxField>
                    <asp:BoundField DataField="pcount" HeaderText="pcount" SortExpression="pcount"></asp:BoundField>
                </Columns>
            </asp:GridView>
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString='<%$ ConnectionStrings:collGamesOgConnectionString %>' SelectCommand="SELECT * FROM [ajayk57_games]"></asp:SqlDataSource>
        </article>
        <article>
            <h2>Table games ordered by player count(ascending)</h2>
            <asp:GridView ID="GridView2" runat="server" DataSourceID="SqlDataSource2" AutoGenerateColumns="False" DataKeyNames="id">
                <Columns>
                    <asp:BoundField DataField="id" HeaderText="id" ReadOnly="True" SortExpression="id"></asp:BoundField>
                    <asp:BoundField DataField="name" HeaderText="name" SortExpression="name"></asp:BoundField>
                    <asp:CheckBoxField DataField="is_outdoor" HeaderText="is_outdoor" SortExpression="is_outdoor"></asp:CheckBoxField>
                    <asp:BoundField DataField="pcount" HeaderText="pcount" SortExpression="pcount"></asp:BoundField>
                </Columns>
            </asp:GridView>
            <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString='<%$ ConnectionStrings:collGamesOgConnectionString %>' SelectCommand="SELECT * FROM [ajayk57_games] ORDER BY [pcount]"></asp:SqlDataSource>
        </article>
        
    </form>
    <footer>
        Author: Ajay Karthikesan, Roll No. : 57
    </footer>
</body>
</html>
