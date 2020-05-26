

getList = async () => {
  fetch('http://localhost:8080/getAll')
    .then(response => response.json())
    .then((data) => {
      console.log(data);
      for (anime of data) {
        let li = document.createElement("li");
        let t = document.createTextNode(anime.name + ": " + anime.rating);
        li.appendChild(t);
        document.getElementById("animeList").appendChild(li);
      }
    });



  console.log("hi");
}

add = async () => {
  let li = document.createElement("li");
  let nameInput = document.getElementById("nameInput");
  let ratingInput = document.getElementById("ratingInput");
  let t = document.createTextNode(nameInput + ratingInput);
  li.appendChild(t);

  if (nameInput === "" || ratingInput === "") {
    alert("Please fill out all inputs.")
  } else {
    document.getElementById("animeList").appendChild(li);
  }
  console.log("hi");
}