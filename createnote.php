<?php
// define variables and set to empty values
$nameErr = $titleErr = "";
$name = $title = $content = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Name is required";
  } else {
    $name = test_input($_POST["name"]);
    // check if name only contains letters and whitespace
    if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
      $nameErr = "Only letters and white space allowed";
    }
  }

  if (empty($_POST["title"])) {
    $titleErr = "Title is required";
  } else {
    $title = test_input($_POST["title"]);
    // check if name only contains letters and whitespace
    if (!preg_match("/^[a-zA-Z-' ]*$/",$title)) {
      $titleErr = "Only letters and white space allowed";
    }
  }

  if (empty($_POST["content"])) {
    $content = "(No content)";
  } else {
    $content = test_input($_POST["content"]);
  }

}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
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
                    <a href="mynotes.php"><button>View Notes</button></a>
                </li>
                <li>
                    <a href="createnote.php"><button id="navoffset">Create New</button></a>
                </li>
            </ul>
        </nav>
        <div id="pageinfo">
        <br>
        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        Your Name:<br><input type="text" name="name" value="<?php echo $name;?>">
        <span class="error">* <?php echo $nameErr;?></span> 
        <br><br>
        Note Title:<br><input type="text" name="title" value="<?php echo $title;?>">
        <span class="error">* <?php echo $titleErr;?></span>
        <br><br>
        Content:<br><textarea name="content" rows="5" cols="40">
        <?php echo $content;?></textarea>
        <br><br>
        <input type="submit" name="submit" value="Submit">  
        </form>

        </div>
    </body>
</html>

<?php
#a preserves and write
if(empty($nameErr) && empty($titleErr)){
  if(!empty($name) && !empty($title) && !empty($content)){
    $myfile = fopen("notes.csv", "a");
    $txt = $name . ", " . $title . ", " . $content . "\n";
    fwrite($myfile, $txt);
    fclose($myfile);
    echo "<meta http-equiv = \"refresh\" content = \"1; url = mynotes.php\" />";
  }
}
?>