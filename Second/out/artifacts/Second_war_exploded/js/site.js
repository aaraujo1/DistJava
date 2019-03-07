var elements = document.getElementById("my-form").elements;

for (var i = 0, element; element = elements[i++];) {
    if (element.type === "text" && element.value === "")
        console.log("it's an empty textfield");
}

//https://stackoverflow.com/questions/19978600/how-to-loop-through-elements-of-forms-with-javascript

//https://stackoverflow.com/questions/133925/javascript-post-request-like-a-form-submit