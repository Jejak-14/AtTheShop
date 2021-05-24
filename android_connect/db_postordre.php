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
$sql = "INSERT INTO Ordre Besked";
$result = $conn->query($sql);

    if(mysqli_query($mysqli, $sql)){
        
        
    } else{
        echo "Fejl $sql. " . mysqli_error($mysqli);
    }

$conn->close();
?>
