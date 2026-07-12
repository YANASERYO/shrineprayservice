document.addEventListener("DOMContentLoaded", () => {
    const supporterType = document.getElementById("supporterType");
    const corporateFields = document.querySelectorAll(".corporate-field");
    const individualFields = document.querySelectorAll(".individual-field");

    if (!supporterType) {
        return;
    }

    const switchFields = () => {
        const isCorporation = supporterType.value === "CORPORATION";
        const isIndividual = supporterType.value === "INDIVIDUAL";

        corporateFields.forEach(field => {
            field.style.display = isCorporation ? "" : "none";
        });

        individualFields.forEach(field => {
            field.style.display = isIndividual ? "" : "none";
        });
    };

    supporterType.addEventListener("change", switchFields);
    switchFields();
});