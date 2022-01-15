var search = document.getElementById("search");
var button = document.getElementById("button");
var input = document.getElementById("input");
const profileURL = "http://127.0.0.1:5500/profile.html";
function loading() {
  search.classList.add("loading");

  setTimeout(function () {
    search.classList.remove("loading");
    location.assign(profileURL);
  }, 3000);
}

button.addEventListener("click", loading);

input.addEventListener("keydown", function () {
  if (event.keyCode == 13) loading();
});
