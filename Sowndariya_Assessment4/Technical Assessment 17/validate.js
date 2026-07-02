document.getElementById('registrationForm').addEventListener('submit', function(event) {
    let isValid=true;

    // full name
    const name=document.getElementById('name').value;
    if (name.trim()==='') {
        document.getElementById('nameError').textContent='Full Name is required.';
        isValid = false;
    }

    // email
    const email=document.getElementById('email').value;
    if (!email.includes('@') || !email.endsWith('.com')) {
        document.getElementById('emailError').textContent='Invalid email format. Must contain @ and end with .com';
        isValid = false;
    }

    // date of birth
    const dobValue=document.getElementById('dob').value;
    if (!dobValue){
        document.getElementById('dobError').textContent='Date of Birth is required.';
        isValid=false;
    }
    else {
        const birthDate=new Date(dobValue);
        const today=new Date();
        let age=today.getFullYear() - birthDate.getFullYear();
        const m=today.getMonth()-birthDate.getMonth();
        if (m<0 || (m===0 && today.getDate()<birthDate.getDate())) {
            age--;
        }
        //age less than 17
        if (age<17) {
            document.getElementById('dobError').textContent='age must be at least 17 years old.';
            isValid = false;
        }
    }

    // course
    const course=document.getElementById('course').value;
    if (course==='') {
        document.getElementById('courseError').textContent='Please select a course.';
        isValid=false;
    }

    if (!isValid) {
        event.preventDefault();
    }
});
