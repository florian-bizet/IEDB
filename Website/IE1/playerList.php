<?php 
    include("htmlstruct.inc.php");
    include("DBIE1.inc.php");
    include_once("PlayerIE1.inc.php");

    ini_set('display_errors', 1);
    ini_set('display_startup_errors', 1);
    error_reporting(E_ALL);

    echo(htmlHeader("playerList") );
    echo(pageContent());
    echo(htmlFooter() );

    function pageContent() {
        
        $htmlCode = "<section id=\"playerList\">
                        <input type='text' id='searchBar' onkeyup='playerSearch()' placeholder='Search...'>
                        <ul id='listToSearch'>";

        $connexion = DBIE1::getInstance();

        $index = 0;

        foreach ($connexion->getPlayerList() as $player) {
            $htmlCode = $htmlCode . "<li>";
            $htmlCode = $htmlCode .     "<a href='viewPlayer.php?id=". $player->getID() ."'  class='" . ($index%2 == 0 ? "evenID" : "oddID") . "'>";
            $htmlCode = $htmlCode .         "<p>" . $player->getShortRomanName() . "</p>";
            $htmlCode = $htmlCode .     "</a>";
            $htmlCode = $htmlCode . "</li>";
            $index++;
        }

        $htmlCode = $htmlCode . "</ul></section>";

        return $htmlCode;
    }
?>