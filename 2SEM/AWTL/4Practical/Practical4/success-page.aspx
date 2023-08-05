<%@ Page Title="" Language="C#" MasterPageFile="~/master.Master" AutoEventWireup="true" CodeBehind="success-page.aspx.cs" Inherits="Practical4.SuccessPage" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <label>You've Registered Successfully</label><br />
    <label>Name: </label>
    <asp:Label ID="nameLbl" runat="server" Text="Label"></asp:Label><br />
    <label>Email ID: </label>
    <asp:Label ID="emailLbl" runat="server" Text="Label"></asp:Label><br />
</asp:Content>
