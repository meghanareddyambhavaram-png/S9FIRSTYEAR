const display = document.getElementById("feedbackDisplay");
const filter = document.getElementById("filter");

// Change key based on form
let feedbackList = JSON.parse(localStorage.getItem("teacherFeedback")) || [];

displayFeedback(feedbackList);

filter.addEventListener("change", () => {
  if (filter.value === "all") {
    displayFeedback(feedbackList);
  } else {
    const filtered = feedbackList.filter(f => f.rating === filter.value);
    displayFeedback(filtered);
  }
});

function displayFeedback(list) {
  display.innerHTML = "";
  if (list.length === 0) {
    display.innerHTML = "<p>No feedback available</p>";
    return;
  }

  list.forEach((f, i) => {
    display.innerHTML += `
      <div class="card">
        <b>Subject:</b> ${f.subject || "N/A"}<br>
        <b>Rating:</b> ${f.rating}<br>
        <b>Feedback:</b> ${f.feedback}<br>
        <small>Date: ${f.date}</small>
      </div>
    `;
  });
}