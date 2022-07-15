const URL = 'http://localhost:8080';

function onLoad(){
    document.getElementById("signUpForm").addEventListener("submit", signIn);

}

function signIn(e){
    const data = {};
    const formData = new FormData(e.target);
    data["username"] = formData.get("userName");
    data["password"] = formData.get("passWord");
    e.preventDefault();
    fetch(`${URL}/auth/login`, {
        method: `POST`,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then((response)=> {
        response.text().then((text)=>{
            localStorage.setItem("token", text);
            location.href = `${URL}/main.html`;

        })

    });
    
}