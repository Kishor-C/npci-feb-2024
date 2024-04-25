import { useState } from "react";

// a form to take input from the user
export function ProfileForm() {
    let [name, setName] = useState('');
    let [password, setPassword] = useState('');
    let [phone, setPhone] = useState('');
    let [dob, setDob] = useState('');
    // this callback is called when you submit the form
    let handleSubmit = (e) => {
        e.preventDefault(); // it prevents reloading the browser after submitting
        console.log(name, password, phone, dob);
        alert('Check the console...');
    }

    return (<div>
        <h2>Profile Registration</h2>
        <form onSubmit = {handleSubmit}>
            <input type = 'text' name = 'name' onChange={(e) => setName(e.target.value)} placeholder="Enter name"/>
            <br />
            <input type = 'password' name = 'password' onChange={e => setPassword(e.target.value)} placeholder="Enter pwd"/>
            <br />
            <input type = 'number' name = 'phone' onChange={e => setPhone(e.target.value)} placeholder="Enter ph"/>
            <br />
            <input type = 'date' name = 'dob' onChange={e=>setDob(e.target.value)} />
            <br />
            <input type = 'submit' value = 'Register'></input>
        </form>
    </div>);

}
// you can import Simple in another JS file
export function Simple() {
    let username = 'Kishor';
    return (<div>
        <h3>Hello {username}</h3>
    </div>)
}

export function User(props) {
    let name = props.name;
    let age = props.age;
    return (<div>
        <h2>User Component</h2>
        <h3>Hello {name}, your age is {age}</h3>
    </div>)
}
// a component that takes complex object which will have name, dob, email, imageURL
export function Profile(props) {
    let profile = props.profile; // <Profile profile = {object} />
    // profile.name, profile.dob, profile.email, profile.imageURL
    return (<div>
        <img src = {profile.imageURL} width = "100" heigth = "100" style={{borderRadius:'50%'}}/>
        <p>Name: {profile.name}</p>
        <p>Birthday: {profile.dob}</p>
        <p>Email: {profile.email}</p>
    </div>)
}