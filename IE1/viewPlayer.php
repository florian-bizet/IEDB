<?php 
    include("htmlstruct.inc.php");
    include("DBIE1.inc.php");
    include_once("PlayerIE1.inc.php");

    ini_set('display_errors', 1);
    ini_set('display_startup_errors', 1);
    error_reporting(E_ALL);

    echo(htmlHeader("") );
    echo(pageContent());
    echo(htmlFooter() );

    function pageContent() {
        $htmlCode = "<section id='playerInfo'>";
    }

?>