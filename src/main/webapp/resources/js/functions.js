function  deleteStudents(){

    const checkedCheckBoxes = document.querySelectorAll('input[name=studentId]:checked');

    if (checkedCheckBoxes.length == 0){
        alert("Пожалуйста, выберите хотя бы одного студента.");
        return;
    }
    let ids = ""; //"1 3 5 ";

    for (let i = 0; i<checkedCheckBoxes.length; i++){
        ids = ids + checkedCheckBoxes[i].value + " ";
    }
    document.getElementById("idsForDelete").value = ids;
    document.getElementById("deleteForm").submit();

}

function  modifyStudent(){

    const checkedCheckBoxes = document.querySelectorAll('input[name=studentId]:checked');

    if (checkedCheckBoxes.length == 0){
        alert("Пожалуйста, выберите одного студента.");
        return;
    }

    if (checkedCheckBoxes.length > 1){
        alert("Пожалуйста, выберите только одного студента.");
        return;
    }

    let id = checkedCheckBoxes[0].value;

    document.getElementById("idForModify").value = id;
    document.getElementById("modifyForm").submit();

}

function  studentProgress(){

    const checkedCheckBoxes = document.querySelectorAll('input[name=studentId]:checked');

    if (checkedCheckBoxes.length == 0){
        alert("Пожалуйста, выберите одного студента.");
        return;
    }

    if (checkedCheckBoxes.length > 1){
        alert("Пожалуйста, выберите только одного студента.");
        return;
    }

    let id = checkedCheckBoxes[0].value;

    document.getElementById("idForProgress").value = id;
    document.getElementById("progressForm").submit();

}