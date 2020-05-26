async function removeAllChildNodes(parent) {
  while (parent.firstChild) {
    parent.removeChild(parent.firstChild);
  }
}

async function getList() {
  let parent = document.getElementById("animeList");
  this.removeAllChildNodes(parent); // clear the list

  fetch('http://localhost:8080/getAll')
    .then(response => response.json())
    .then((data) => {
      console.log("/getAll", data);
      for (anime of data) {
        let li = document.createElement("li");
        let t = document.createTextNode(anime.name + ": " + anime.rating);
        li.appendChild(t);
        document.getElementById("animeList").appendChild(li);
      }
    }).catch(error => { console.log(error); });
}

async function add() {
  let name = document.getElementById("nameInput").value;
  let rating = document.getElementById("ratingInput").value;

  if (name === "" || rating === "") {
    alert("Please fill in both inputs.");
  }

  // the point of 'await' here is to wait for the post call to execute, then 
  // update the list with 'getList()'
  await fetch(`http://localhost:8080/create?name=${name}&rating=${rating}`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: null
  })
    .then(response => console.log("/create", response))
    .catch(error => { console.log(error); })

  this.getList(); // refresh the list
}
