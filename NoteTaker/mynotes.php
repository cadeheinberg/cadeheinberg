<?php 
$myfile = fopen("notes.csv", "r") or die("Unable to open file!");
$uploads = array();
while(!feof($myfile)) {
    array_push($uploads, fgets($myfile));
}

$uploads = array_reverse($uploads);

fclose($myfile);
?>

<html>
    <head>
        <META charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Notepad</title>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin"/>
        <link href="../profile.css" type="text/css" rel="stylesheet"/>
        <link href="notes.css" type="text/css" rel="stylesheet"/>
    </head>

    <body>
        <header>
            <div id="selfiebox">
                <a href="../index.html"><img src="../selfie.png" id="selfie"/></a>
            </div>
            <div id="mynamebox">
                <h1>Cade's Notepad</h1>
            </div>
        </header>
        <nav>
            <ul>
                <li>
                    <a href="mynotes.php"><button id="navoffset">View Notes</button></a>
                </li>
                <li>
                    <a href="createnote.php"><button>Create New</button></a>
                </li>
            </ul>
        </nav>
        <div id="pageinfo">

            <?php
            foreach ($uploads as $upload){
                if(empty($upload)){
                    continue;
                }
                $upload_array = explode (",", $upload); 
                echo "<section id=\"welcome\">";
                echo "<p><p id=\"posttitle\">". $upload_array[1] . "</p>";
                echo "<strong style=\"font-size: 20px\">Posted by: ". $upload_array[0] . "</strong><br>";
                echo "<p style=\"font-size: 19px\">$upload_array[2]</p>";
                echo "</p></section>";
            }
            ?>
        </div>
    </body>
</html>
