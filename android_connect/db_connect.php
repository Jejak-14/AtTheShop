<?php
$servername = "localhost";
            $username = "root";
            $password = "";
            $dbname = "attheshop";
            $tablename = "ordre";

            $conn = new mysqli($servername, $username, $password, $dbname);
                    // Check connection
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }else {
                        echo "<h2>Thumps up Nickolai The server is running</h2>";

                    }
?>
