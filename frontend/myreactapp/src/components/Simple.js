import { useState } from "react";
import axios from 'axios';
import {useNavigate, useParams } from 'react-router-dom';

export function ProfileSuccess() {
    let {id} = useParams();  // success/:id >> success/100, success/200, success/300
    return (<div>
        <h3>Registered with an id: {id}</h3>
    </div>)
}

export function ProfileList() {
    let [list, setList] = useState([]);
    let URL = 'http://localhost:9091/api/profile';
    let handleClick = (e) => {
        axios.get(URL).then(response => setList(response.data));
    }
    return (<div>
        <h3>List of profiles</h3>
        <button onClick = {handleClick} className = 'btn btn-primary'>Refresh</button>
        <table className = 'table'>
            <thead>
                <tr>
                    <th>Pic</th><th>Profile ID</th><th>Name</th><th>Phone</th>
                    <th>Birthday</th>
                </tr>
            </thead>
            <tbody>
                {list.map((profile, index)=>
                <tr key = {index}>
                    <td>Image{index}</td><td>{profile.id}</td><td>{profile.name}</td>
                    <td>{profile.phone}</td><td>{profile.dob}</td>
                </tr>)}
            </tbody>
        </table>
    </div>)
}



// create a component DeleteProfile that takes the id and deletes the profile

export function UsersFromJson() {
    let URL = 'https://jsonplaceholder.typicode.com/users';
    let [id, setId] = useState('');
    let handleClick = (e) => {
        axios.get(`${URL}/${id}`)
        .then(response => setUser(response.data))
        .catch(error => console.log(error));
    }
    let [user,setUser] = useState('');
    return (<div>
        <input type = 'number' name = 'id' onChange = {e => setId(e.target.value)} placeholder="Enter id"/>
        <button className = 'btn btn-primary' onClick = {handleClick}>Search</button>
        <div>
            <p>Hello {user.username}, your email: {user.email}</p>
        </div>
    </div>);
}

// a form to take input from the user
export function ProfileForm() {
    let [name, setName] = useState('');
    let [password, setPassword] = useState('');
    let [phone, setPhone] = useState('');
    let [dob, setDob] = useState('');
    let [profile, setProfile] = useState('');
    let URL = 'http://localhost:9091/api/profile';
    let navigate = useNavigate();
    // this callback is called when you submit the form
    let handleSubmit = (e) => {
        e.preventDefault(); // it prevents reloading the browser after submitting
       axios.post(URL, {"name":name, "dob":dob, "phone":phone})
       .then(response => navigate(`/success/${response.data.id}`))
       .catch(error => console.log(error));
    }
    return (<div>
        <h2>Profile Registration</h2>
        {profile != '' || undefined ? (<h3 className = 'text-success'>Profile Registered with an id {profile.id}</h3>) : ''}
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