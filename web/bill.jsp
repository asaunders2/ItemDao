<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.aaron.model.Item" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aaron's Game Store</title>
    <link rel="stylesheet" href="./css/theStyle.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Aaron's Online Game Store billing page.">
</head>
<body onload="saveTable()">
<div id="wrapper">
    <header>
        <h1>Aaron's Game Store Billing</h1>
    </header>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="cat.go">Catalog</a></li>
            <li><a href="cart.go">Shopping Cart</a></li>
        </ul>
    </nav>
    <main>
        <br>
        <h2>Billing</h2>

        <input type="text" id="myInput" onkeyup="getSearchTerm()" placeholder="Search for item">
        <input class="btn btn-lg" type="button" value="Refresh" id="refresh" onclick="window.location.reload()">

        <form action="bill.go">
            <table id="myTable">
                <th>Name</th>
                <th>Price</th>
                <th>Item #</th>
                </tr>
                <tbody>
                <%
                    List recs = (List) request.getAttribute("catalog");
                    Iterator it = recs.iterator();
                    double total = 0;
                    while (it.hasNext()) {
                        Item item = (Item) it.next();
                        out.print("<tr class='purch'><td> " + item.getName() + " </td>" +
                                "<td>" + String.format("$%3.2f",item.getPrice()) + "</td></tr>");
                        total+=item.getPrice();
                    }
                    out.print("<tr class='total' ><td>Subtotal:</td><td>" +
                            String.format("$%3.2f", total) + "</td><td></td></tr>");
                    out.print("<tr class='total' ><td>Tax:</td><td>" +
                            String.format("$%3.2f", (total * .085)) + "</td><td></td></tr>");
                    out.print("<tr class='total' ><td>Grand Total:</td><td>" +
                            String.format("$%3.2f", (total + (total * .085))) + "</td><td></td></tr>");
                %>
                </tbody>
            </table>
            <br>
            <button type="submit">Purchase</button>
        </form>
    </main>
    <footer>
        <p><a href="tel:262-456-6487">P: 262-456-6487</a>
            &nbsp; | &nbsp; Aaron's Game Store</p>
        <p>Copyright &copy; 2019</p>
    </footer>
</div>
</body>
</html>