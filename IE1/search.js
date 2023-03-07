function playerSearch() {
    let textfield = document.getElementById("searchBar");
    let input = (textfield != null ? textfield.value.toUpperCase() : null);

    if (input == null) {return;}

    let ul = document.getElementsByTagName("ul")[0];
    let playerList = ul.getElementsByTagName("li");

    for (let li of playerList) {
        let a = li.getElementsByTagName("a")[0];
        let p = a.getElementsByTagName("p")[0];

        let playerName = p.textContent || p.innerHTML;

        if (playerName.toUpperCase().indexOf(input) > -1) {
            li.style.display = "";
        } else {
            li.style.display = "none";
        }
    }

}