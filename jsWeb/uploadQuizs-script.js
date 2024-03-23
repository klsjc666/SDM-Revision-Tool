const submitButton = document.getElementById("submitButton")
const inputQuizName = document.getElementById("inputQuizName")
const inputQuizQuestion = document.getElementById("inputQuizQuestion")
const inputQuizFeedbacks = document.getElementById("inputQuizFeedbacks")

submitButton.addEventListener("click", submitQuiz)

function submitQuiz(){
    var xhr = new XMLHttpRequest()
    xhr.open("POST","http://localhost:8080/quiz/save",false)
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify({"quizId":inputQuizName.value,"quizQuestion":inputQuizQuestion.value}))
    var feedbacks = (inputQuizFeedbacks.value).split('\n\n')
    for (feedback in feedbacks){
        xhr.open("POST","http://localhost:8080/feedback/save",false)
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify({"feedbackNumber":(parseInt(feedback) + 1),"feedbackText":feedbacks[feedback],"quizId":inputQuizName.value}))
    }
}