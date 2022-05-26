class CandidateComponent{

    //State = informacion que se esta mostrando en el componente
    constructor(candidate){
        this.candidate = candidate;
    }

    render(container){
      let html=`<div class="card-group">
      <div class="card text-center" style="width: 24rem;">
      <img src="${this.candidate.presidentImage}" class="card-img-top" alt="..." width="400px" height="400px">
      <div class="row">
<div class="col-sm-6">
  <div class="card">
    <div class="card">
    <h7 class="card-title"><b> PRESIDENTE</b><br>${this.candidate.president}</h7>
    </div>
  </div>
</div>
<div class="col-sm-6">
  <div class="card">
    <div class="card-body">
    <h7 class="card-title"><b> VICEPRESIDENTE</b><br>${this.candidate.vice}</h7>
    </div>
    
  </div> 
      
</div>
<h7 class="card-title"><b> PARTIDO</b><br>${this.candidate.party}</h7>
</div>

      
<a href="#" id="button${this.candidate.id}" class="btn btn-primary">VOTAR</a>
      </div>
      
    </div>`;

    if (this.candidate.president=="VOTO EN BLANCO"){
      html=`<div class="card-group">
      <div class="card text-center" style="width: 24rem;">
      <img src="${this.candidate.presidentImage}" class="card-img-top" alt="..." width="400px" height="400px">
      <div class="card-body">
          <h3 class="card-title align-center">VOTO EN BLANCO</h3>
          </div>
      <a href="#" id="button${this.candidate.id}" class="btn btn-primary">VOTAR</a>      
      </div>
    </div>`;
  }

  let root = document.createElement('div');
  root.innerHTML = html.trim();
  container.appendChild(root.firstChild);

  let button = document.getElementById(`button${this.candidate.id}`);
  button.addEventListener('click',this.action.bind(this)); 
}

action=async(event)=>{
  event.preventDefault();
  let xhr = new XMLHttpRequest();
  let url = `http://localhost:8080/Votation/Elecciones/Presidencia/Resultados`;
  xhr.open('PUT',url);
  xhr.setRequestHeader('Content-Type','application/json');
  xhr.send(JSON.stringify(this.candidate));
  window.alert('Voto Registrado');
  window.location.href="votes.html";
  }
}