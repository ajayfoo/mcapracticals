<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication2.WebForm1" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>Practical 4-B</title>
    <script type="text/javascript" src="angular.min.js"></script>
    <style type="text/css">
 .auto-style1 {
 width: 49%;
 height: 100%;
 } 
 </style>
</head>
<body ng-app="myApp">
    <div ng-controller="myCtrl">
        <table class="auto-style1">
            <tr>
                <td>
                    <h3>
                        Un-Ordered</h3>
                </td>
                <td>
                    <h3>
                        Orderby Filter : Order by id</h3>
                </td>
            </tr>
            <tr>
                <td>
                    <table border="1" cellspacing="0" cellpadding="5">
                        <thead>
                            <th>
                                Id
                            </th>
                            <th>
                                Name
                            </th>
                            <th>
                                Salary
                            </th>
                            <th>
                                Date of joining
                            </th>
                        </thead>
                        <tr ng-repeat="x in emp">
                            <td>
                                {{x.id}}
                            </td>
                            <td>
                                {{x.name}}
                            </td>
                            <td>
                                {{x.sal}}
                            </td>
                            <td>
                                {{x.doj}}
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table border="1" cellspacing="0" cellpadding="5">
                        <thead>
                            <th>
                                Id
                            </th>
                            <th>
                                Name
                            </th>
                            <th>
                                Salary
                            </th>
                            <th>
                                Date of joining
                            </th>
                        </thead>
                        <tr ng-repeat="x in emp | orderBy: 'id'">
                            <td>
                                {{x.id}}
                            </td>
                            <td>
                                {{x.name}}
                            </td>
                            <td>
                                {{x.sal}}
                            </td>
                            <td>
                                {{x.doj}}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <h3>
            Number filter</h3>
        <ul>
            <li ng-repeat="x in emp">Salary of {{x.name}} is {{ x.sal | number:3}}</li>
        </ul>
        <h3>
            Currency filter</h3>
        <ul>
            <li ng-repeat="x in emp">Salary of {{x.name}} is {{x.sal|currency:'Rs.'}}</li>
        </ul>
    </div>
    <script> 
         var app = angular.module("myApp", []);
        app.controller("myCtrl", function ($scope) {
            $scope.emp = [{ id: '57', name: 'Ajay Karthikesan', sal: '90000', doj: '03-10-2000' }, { id: '103', name: 'James', sal: '60000', doj: '19-01-1999' }, { id: '120', name: 'August', sal: '10000', doj: '12-02-1996'}]
        }); 
    </script>
</body>
</html>
