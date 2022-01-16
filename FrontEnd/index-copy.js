var search = document.getElementById("search");
var button = document.getElementById("button");
var input = document.getElementById("input");
let info = undefined;
const profileURL = "http://127.0.0.1:5500/profile.html";
const IPBack =
  "http://95b7-181-65-18-224.ngrok.io/web-perfil/perfil/crearPerfil";

function isValidHttpUrl(string) {
  let url;

  try {
    url = new URL(string);
  } catch (_) {
    return false;
  }

  return true;
}

async function loading() {
  let url = document.getElementById("input").value;
  //validations
  if (url === "") return;
  if (!isValidHttpUrl(url)) {
    alert("Ingrese una URL válida");
    return;
  }

  search.classList.add("loading");

  let objectt = { url: url };

  info = await fetch(IPBack, {
    method: "POST",
    body: JSON.stringify(objectt),
    headers: {
      "Content-Type": "application/json",
    },
  });
  info = await info.json();
  console.log(info);
  localStorage.setItem("object", JSON.stringify(info));
  search.classList.remove("loading");

  location.assign(profileURL);
}

button.addEventListener("click", loading);

input.addEventListener("keydown", function () {
  if (event.keyCode == 13) loading();
});
