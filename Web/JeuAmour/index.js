function getRandomInt() {
    return Math.floor(Math.random() * 6);
}



function main(nbMoi, guess){
    let nbBot = getRandomInt()
    let guessBot = getRandomInt()
    let somme = parseInt(nbMoi) + nbBot
    document.getElementById("guessBot").value = guessBot
    document.getElementById("somme").value = somme
    document.getElementById("choixBot").value = nbBot
    if(Math.abs(somme - parseInt(guess)) == Math.abs(somme - guessBot)){
        document.getElementById("response").value = "Egalité!"
    }
    else if(Math.abs(somme - parseInt(guess)) > Math.abs(somme - guessBot)){
        document.getElementById("response").value = "Perdu!"
    }
    else{
        document.getElementById("response").value = "Gagné!"
    }
    return false
}