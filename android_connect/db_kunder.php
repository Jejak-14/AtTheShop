<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "attheshop";


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
    
// Check connection
if ($conn->connect_error) {
    die("NEW Connection failed: " . $conn->connect_error);
}


 //response array 
 $response = array();     
    
// Select table
$sql = "SELECT * FROM kunder";
$result = $conn->query($sql);

     
if ($result->num_rows > 0) {
    
    // output data of each row
    while($row = $result->fetch_assoc()) {
    
        $response[] = $row;
    }
     echo json_encode($response);
} else {
    echo "0 results";
}

$conn->close();
?>
