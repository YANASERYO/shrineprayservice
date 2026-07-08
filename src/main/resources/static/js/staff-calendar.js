window.addEventListener("DOMContentLoaded", () => {
    const calendarEl = document.getElementById("staffCalendar");

    if (!calendarEl) {
        return;
    }

    const calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: "dayGridMonth",
        locale: "ja",
        height: "100%",
        headerToolbar: {
            left: "prev,next today",
            center: "title",
            right: "dayGridMonth,timeGridWeek,timeGridDay"
        },
        buttonText: {
            today: "今日",
            month: "月",
            week: "週",
            day: "日"
        },
        events: "/staff/schedule/events"
    });

    calendar.render();
});