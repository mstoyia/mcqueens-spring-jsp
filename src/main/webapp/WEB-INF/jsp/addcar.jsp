<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Car</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <h1>Add Cars</h1>

    <form method="post" action="/addcar">
        <label>Manufacturer Name</label><br>
        <input type="text" name="manufacturerName"/><br>
        <label>Model</label><br>
        <input type="text" name="model"/><br>
        <label>Year</label><br>
        <input type="number" name="year"/><br>
        <label>Date of Purchase</label><br>
        <input type="date" name="dateOfPurchase"/><br>
        <label>Vin</label><br>
        <input type="text" name="vin"/><br>
        <label>Price</label><br>
        <input type="text" name="price"/><br>
        <label>Mileage</label><br>
        <input type="number" name="mileage"/><br>
        <label>Description</label><br>
        <input type="text" name="description"/><br>
        <label>Photo Url</label><br>
        <input type="text" name="photoUrl"/><br>

        <button type="submit">Submit</button>
    </form>


   
    

</body>
</html>