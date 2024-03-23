const selectedQuiz = document.getElementById("selectedQuiz")
const inputFeedbackText = document.getElementById("inputFeedbackText")
const answerPicture = document.getElementById("answerPicture")
const submitButton = document.getElementById("submitButton")

var quizs = {}

submitButton.addEventListener("click", submitAnswer)

var xhr = new XMLHttpRequest()
xhr.open("POST","http://localhost:8080/quiz/page",false)
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onload = function(){
    if (xhr.status === 200){
        quizs = JSON.parse(xhr.responseText).data
    }
}
xhr.send(JSON.stringify({}))

for (quiz in quizs){
    selectedQuiz.options.add(new Option(quizs[quiz].quizId,quizs[quiz].quizId))
}

function submitAnswer(){
    //console.log(answerPicture.files[0])
    //console.log({"file":answerPicture.files[0],"quizId":selectedQuiz.value,"teacher":true,"feedback":inputFeedbackText.value})
    var feedbacks = {}
    var xhr = new XMLHttpRequest()
    xhr.open("POST","http://localhost:8080/feedback/page",false)
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function(){
    if (xhr.status === 200){
        feedbacks = JSON.parse(xhr.responseText).data
        }
    }
    xhr.send(JSON.stringify({"quizId":selectedQuiz.value}))
    var feedbackSplit = (inputFeedbackText.value).split('\n\n')
    var feedbackNumbers = ""
    var first = true
    for (feedback in feedbackSplit){
        for (index in feedbacks){
            //console.log(feedbackSplit[feedback],feedbacks[index].feedbackText)
            if (feedbackSplit[feedback] == feedbacks[index].feedbackText){
                //console.log(feedback,feedbacks[index].feedbackText)
                if (first){
                    first = false
                }else{
                    feedbackNumbers += ","
                }
                feedbackNumbers += feedbacks[index].feedbackNumber
            }
        }
    }
    let formData = new FormData()
    formData.append("file",answerPicture.files[0])
    formData.append("quizId",selectedQuiz.value)
    formData.append("teacher",true)
    formData.append("feedback",feedbackNumbers)
    var xhr = new XMLHttpRequest()
    xhr.open("POST","http://localhost:8080/image/uploadAnswer",false)
    //xhr.setRequestHeader("Content-Type", "application/json");
    //xhr.send(JSON.stringify({"file":answerPicture.files[0],"quizId":selectedQuiz.value,"teacher":true,"feedback":inputFeedbackNumbers.value}))
    xhr.send(formData)
}
