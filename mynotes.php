<?php 
$myfile = fopen("notes.csv", "r") or die("Unable to open file!");

#get the entire file as a String
#(name of the file, maximum number of bites to read)
#echo fread($myfile,filesize("webdictionary.txt"));

#print line by line
#feof() checks if the pointer is at the end of the file
#fgets() goes line by line
#fgetc() goes char by char
$header_string = fgets($myfile);
$header_array = explode (",", $header_string); 
$title = $header_array[0];
$username = $header_array[1];
$content = $header_array[2];

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
        <link href="profileCSS/notes.css" type="text/css" rel="stylesheet"/>
    </head>

    <body>
        <header>
            <div id="selfiebox">
                <img src="selfie.png" id="selfie"/>
            </div>
            <div id="mynamebox">
                <h1>Cade's Notepad</h1>
            </div>
        </header>
        <nav>
            <ul>
                <li>
                    <a href="index.html"><button>Home</button></a>
                </li>
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
                echo $upload_array[2];
                echo "<br><br>Uploaded by: ". $upload_array[0] . "</p></section>";
            }
            ?>

        </div>
    </body>
</html>
