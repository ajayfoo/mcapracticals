<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Practical6.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="id" DataSourceID="SqlDataSource1">
                <Columns>
                    <asp:BoundField DataField="id" HeaderText="id" ReadOnly="True" SortExpression="id" />
                    <asp:BoundField DataField="name" HeaderText="name" SortExpression="name" />
                    <asp:BoundField DataField="score" HeaderText="score" SortExpression="score" />
                </Columns>
            </asp:GridView>
            <br />
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:collConnectionString %>" OnSelecting="SqlDataSource1_Selecting" ProviderName="<%$ ConnectionStrings:collConnectionString.ProviderName %>" SelectCommand="SELECT * FROM [ajayk57_student]"></asp:SqlDataSource>
            <asp:FormView ID="FormView1" runat="server" BorderStyle="Dotted" DataKeyNames="id" DataSourceID="SqlDataSource1" OnPageIndexChanging="FormView1_PageIndexChanging">
                <EditItemTemplate>
                    id:
                    <asp:Label ID="idLabel1" runat="server" Text='<%# Eval("id") %>' />
                    <br />
                    name:
                    <asp:TextBox ID="nameTextBox" runat="server" Text='<%# Bind("name") %>' />
                    <br />
                    score:
                    <asp:TextBox ID="scoreTextBox" runat="server" Text='<%# Bind("score") %>' />
                    <br />
                    <asp:LinkButton ID="UpdateButton" runat="server" CausesValidation="True" CommandName="Update" Text="Update" />
                    &nbsp;<asp:LinkButton ID="UpdateCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
                </EditItemTemplate>
                <InsertItemTemplate>
                    id:
                    <asp:TextBox ID="idTextBox" runat="server" Text='<%# Bind("id") %>' />
                    <br />
                    name:
                    <asp:TextBox ID="nameTextBox" runat="server" Text='<%# Bind("name") %>' />
                    <br />
                    score:
                    <asp:TextBox ID="scoreTextBox" runat="server" Text='<%# Bind("score") %>' />
                    <br />
                    <asp:LinkButton ID="InsertButton" runat="server" CausesValidation="True" CommandName="Insert" Text="Insert" />
                    &nbsp;<asp:LinkButton ID="InsertCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
                </InsertItemTemplate>
                <ItemTemplate>
                    id:
                    <asp:Label ID="idLabel" runat="server" Text='<%# Eval("id") %>' />
                    <br />
                    name:
                    <asp:Label ID="nameLabel" runat="server" Text='<%# Bind("name") %>' />
                    <br />
                    score:
                    <asp:Label ID="scoreLabel" runat="server" Text='<%# Bind("score") %>' />
                    <br />

                </ItemTemplate>
            </asp:FormView>
            <br />
            <asp:DataList ID="DataList1" runat="server" BorderStyle="Groove" DataKeyField="id" DataSourceID="SqlDataSource1" GridLines="Horizontal">
                <ItemTemplate>
                    id:
                    <asp:Label ID="idLabel" runat="server" Text='<%# Eval("id") %>' />
                    <br />
                    name:
                    <asp:Label ID="nameLabel" runat="server" Text='<%# Eval("name") %>' />
                    <br />
                    score:
                    <asp:Label ID="scoreLabel" runat="server" Text='<%# Eval("score") %>' />
                    <br />
<br />
                </ItemTemplate>
            </asp:DataList>
        </div>
    </form>
</body>
</html>
