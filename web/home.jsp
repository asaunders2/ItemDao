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
    <meta name="description" content="Aaron's Online Game Store home page.">
</head>
<script>
    var fullTable = [];

    function saveTable() {
        $("#products tr").each(function() {
            var arrayOfThisRow = [];
            var tableData = $(this).find('td');
            if (tableData.length > 0) {
                tableData.each(function() { arrayOfThisRow.push($(this).text()); });
                fullTable.push(arrayOfThisRow);
            }
        });
    }

    function getSearchTerm() {
        // Declare variables
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
<body onload="saveTable()">
<div id="wrapper">
        <header>
            <h1>Aaron's Game Store</h1>
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
            <h2>Home</h2>

            <input type="text" id="myInput" onkeyup="getSearchTerm()" placeholder="Search for item">
            <input class="btn btn-lg" type="button" value="Refresh" id="refresh" onclick="window.location.reload()">

            <form action="cartplace.go">
                <table id="myTable">
                    <tr class="header">
                        <th>Name</th>
                        <th>Item #</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Add</th>
                    </tr>
                    <tbody>
                        <%
                            List recs = (List) request.getAttribute("catalog");
                            Iterator it = recs.iterator();

                            while (it.hasNext()) {
                                Item item = (Item) it.next();

                            out.print("<tr class='item' >\n" +

                                    "<td>" + item.getName() + "</td>\n" +
                                    "<td>" + item.getProductNumber() + "</td>\n" +
                                    "<td>" + item.getPrice() + "</td>\n" +
                                    "<td>" + "<img src=images/game" + item.getProductNumber() + ".jpg>" + "</td>\n" +
                                    "</td><td> Add to Cart <input type='checkbox' name='cartItem' value='" +
                                    item.getProductNumber() + "'></tr>");
                            }
                        %>
                    </tbody>
                </table>
                <br>
                <button id="submit" type="submit">Add To Cart</button>
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