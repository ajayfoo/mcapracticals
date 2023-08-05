<%@ Page Title="" Language="C#" MasterPageFile="~/master.Master" AutoEventWireup="true" CodeBehind="index.aspx.cs" Inherits="Practical4.index" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <form runat="server">
        <label>Name <asp:TextBox ID="nameLbl" runat="server"></asp:TextBox></label><asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="This is a required field" ControlToValidate="nameLbl"></asp:RequiredFieldValidator><br />
        <label>Email ID <asp:TextBox ID="emailLbl" runat="server"></asp:TextBox></label><asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="This a required field" ControlToValidate="emailLbl"></asp:RequiredFieldValidator>
        <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ErrorMessage="Please enter a valid email" ControlToValidate="emailLbl" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator><br />
        <asp:Button ID="submitBtn" runat="server" Text="Submit" OnClick="submitBtn_Click" />
    </form>
</asp:Content>
