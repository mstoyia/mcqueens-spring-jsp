<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Details</title>
    <link rel="stylesheet" href="/css/cardetails.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <h1>${carDetail.manufacturerName} ${carDetail.model} Details</h1>
 <div class="cardetailpage">
    <img src="${carDetail.photoUrl}"/>

    <p>Manufacturer: ${carDetail.manufacturerName}</p>
    <p>Price: ${carDetail.price}</p>
    <p>Model: ${carDetail.model}</p>
    <p>Description: ${carDetail.description}</p>
    <p>Mileage: ${carDetail.mileage}</p>
    <p>Date of Purchase: ${carDetail.dateOfPurchase}</p>
    <p>Vin: ${carDetail.vin}</p>

    <button><a href="/cart/add/${carDetail.id}">Add To Cart</a></button>
  </div>
</body>
</html>