async function addMessage(form){
    let data = new FormData(form);
    console.log(data);

    await fetch('http://localhost:8000/add',{
        method: 'POST',
        body: data
    }).then(r => r.json()).then(data => {
        console.log(data);
    })
    window.location.href = "/chat/" + data.get("chat_id");
}