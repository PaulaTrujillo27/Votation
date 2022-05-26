const candidateContainer = document.getElementById('candidate-component');

const getCandidates = async()=>{
  let url = `http://localhost:8080/Votation/Elecciones/Presidencia/Candidatos`;
  let response = await fetch(url, {method:'GET'} );
  let obj = await response.json();

  for(let  i in obj){
      let candidate = new Candidate(obj[i].id,obj[i].president, obj[i].vice, obj[i].presidentImage, obj[i].party,obj[i].votes);
      let component = new CandidateComponent(candidate);
      component.render(candidateContainer);
  }
}

getCandidates();
