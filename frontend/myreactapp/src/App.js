import logo from './logo.svg';
import './App.css';
import { Simple, User, Profile, ProfileForm, UsersFromJson, ProfileList, ProfileSuccess } from './components/Simple';
import { Routes, Link, Route} from 'react-router-dom';

function App() {
  return (<div>
    <div>
      <Link to = "/register">Register Profile</Link> ||
      <Link to = "/list">List Profiles</Link> ||
      <Link to = "/delete">Delete Profile</Link> ||
      <Link to = "/userJson">Users JSON</Link>
    </div> 
    <hr />
    <div>
      <Routes>
        <Route path = '' element = {<div>Show some default component</div>}></Route>
        <Route path = '/register' element = {<ProfileForm />} ></Route>
        <Route path = '/list' element = {<ProfileList />} ></Route>
        <Route path = '/delete' element = {<div>Delete Component - keep the delete component tag</div>}></Route>
        <Route path = '/userJson' element = {<UsersFromJson />}></Route>
        <Route path = '/success/:id' element = {<ProfileSuccess />}></Route>
      </Routes>
    </div>
  </div>)  
}

export default App;
