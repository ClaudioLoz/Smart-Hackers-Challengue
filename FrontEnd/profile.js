// import jsPDF from "./node_modules/jspdf";

let info = JSON.parse(localStorage.getItem("object"));
console.log(info);
let profileURL = location.href.replace("/profile.html", "");

//Guardando nombre
if (info.nombre != "") {
  document.getElementById("nombre_tag").innerHTML =
    '<h1 class="grid-item3">' +
    info.nombre +
    "</h1>" +
    `<div class="grid-item3">
        <a href="` +
    info.linkLinkedin +
    `" target="_blank"><i class="fab fa-linkedin fa-lg"></i></a>
    </div>`;
}

//Guardando seccion información básica
if (info.trabajoActual != "") {
  document.getElementById("informacion_tag").innerHTML =
    `<h3>Información básica</h3>
    <hr class="mt-0 mb-4">
    <div class="row pt-1">
    <div class="col-4 mb-3">
            <h6>Trabajo actual</h6>
            <p class="text-muted">` +
    info.trabajoActual +
    `</p>
        </div>
        <div class="col-4 mb-3">
                <h6>Ubicación</h6>
            <p class="text-muted">` +
    info.residencia +
    `</p>
        </div>
        
    </div>`;
}

//Guardando seccion educación
if (info.educacion.length != 0) {
  let i = 0;
  document.getElementById("edu_tag").innerHTML = "<h3>Educación</h3>";
  for (const edu in info.educacion) {
    document.getElementById("edu_tag").innerHTML +=
      `<hr class="mt-0 mb-4">
    <div class="row pt-1">
        <div class="col-6 mb-3">
            <h6>Centro Educativo</h6>
            <p class="text-muted">` +
      info.educacion[i].centroEducativo +
      `</p>
        </div>
        <div class="col-6 mb-3">
            <h6>Grado</h6>
            <p class="text-muted">` +
      info.educacion[i].grado +
      `</p>
        </div>
        <div class="col-6 mb-3">
            <h6>Periodo</h6>
            <p class="text-muted">` +
      info.educacion[i].periodo +
      `</p>
        </div>
    </div>`;
    i++;
  }
}

if (info.experiencias.length != 0) {
  let i = 0,
    j = 0;
  document.getElementById("exp_tag").innerHTML = "<h3>Experiencia</h3>";
  for (const exp in info.experiencias) {
    document.getElementById("exp_tag").innerHTML +=
      "<h6>" + info.experiencias[i].compania + "</h6>";
    for (const carg in info.experiencias[i].cargo) {
      document.getElementById("exp_tag").innerHTML +=
        `<hr class="mt-0 mb-4">
        <div class="row pt-1">
            <div class="col-6 mb-3">
                <h6>Cargo</h6>
                <p class="text-muted">` +
        info.experiencias[i].cargo[j].cargo +
        `</p>
            </div>
            <div class="col-6 mb-3">
                <h6>Periodo</h6>
                <p class="text-muted">` +
        info.experiencias[i].cargo[j].periodo +
        `</p>
            </div>
        </div>`;
      j++;
    }
    i++;
    j = 0;
  }
}

if (info.intereses.length != 0) {
  let i = 0;
  document.getElementById("intereses_tag").innerHTML = `<h3>Intereses</h3>
    <hr class="mt-0 mb-4">
          <ul>`;
  for (const edu in info.intereses) {
    document.getElementById("intereses_tag").innerHTML +=
      `<li>` + info.intereses[i] + `</li>`;
    i++;
  }
  document.getElementById("intereses_tag").innerHTML += `</ul><br>`;
}

if (info.skills.length != 0) {
  let i = 0;
  document.getElementById("skills_tag").innerHTML = `<h3>Skills</h3>
        <hr class="mt-0 mb-4">
            <ul>`;
  for (const edu in info.skills) {
    document.getElementById("skills_tag").innerHTML +=
      `<li>` + info.skills[i] + `</li>`;
    i++;
  }
  document.getElementById("skills_tag").innerHTML += `</ul><br>`;
}

if (info.voluntariado.length != 0) {
  let i = 0;
  document.getElementById("voluntariado_tag").innerHTML =
    "<h3>Voluntariado</h3>";
  for (const edu in info.voluntariado) {
    document.getElementById("voluntariado_tag").innerHTML +=
      `<hr class="mt-0 mb-4">
    <div class="row pt-1">
        <div class="col-6 mb-3">
            <h6>Causa</h6>
            <p class="text-muted">` +
      info.voluntariado[i].causa +
      `</p>
        </div>
        <div class="col-6 mb-3">
            <h6>Organizacion</h6>
            <p class="text-muted">` +
      info.voluntariado[i].organizacion +
      `</p>
        </div>
        <div class="col-6 mb-3">
            <h6>Periodo</h6>
            <p class="text-muted">` +
      info.voluntariado[i].periodo +
      `</p>
        </div>
        <div class="col-6 mb-3">
            <h6>Rol</h6>
            <p class="text-muted">` +
      info.voluntariado[i].rol +
      `</p>
        </div>
    </div>`;
    i++;
  }
}

let bt = undefined;
bt = document.getElementById("again");

bt.addEventListener("click", function () {
  location.assign(profileURL);
});
