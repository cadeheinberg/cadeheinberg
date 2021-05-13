import React from 'react';
import ReactDOM from 'react-dom';
//Get a Component made in a different file
//This one is called App.js
import Summer from './App.js';
ReactDOM.render(<Summer />, document.getElementById('winter'));

//create using JSX
const myheading = <h1>Cade Heinberg's React Page</h1>
//const myheading = React.createElement('h1', {}, 'I do not use JSX!');

const myexpression = <h1>React is {5 + 5} times better with JSX</h1>;
//React is 10 times better with JSX

//IMPORTANT
//When you have a bunch of elements, make sure there is ONE wrapper around them all
//A div element works well
const mydouble = (
  <div>
    <h1>I am a Header.</h1>
    <h2>I am a smaller header.</h2>
  </div>
);

const myelement = (
  <ul>
    <li>Apples</li>
    <li>Bananas</li>
    <li>Cherries</li>
  </ul>
);

const myinput = <input type="text" />;


//Component and State
//Component properties should be kept in an object called state
//I think state is a field of Component
class Car extends React.Component {
  constructor() {
    super();
    this.state = {color: "red"};
  }
  render() {
    return <h2>Hi, I am a {this.state.color} Car!</h2>;
  }
}
ReactDOM.render(<Car />, document.getElementById('root'));


//Component and Props
class Dog extends React.Component {
  render() {
    return <h2>I am a {this.props.color} Dog!</h2>;
  }
}
ReactDOM.render(<Dog color="green"/>, document.getElementById('dog'));


class Garage extends React.Component {
  render() {
    return (
      <div>
      <h1>Who lives in my Garage?</h1>
      <Car />
      </div>
    );
  }
}
ReactDOM.render(<Garage />, document.getElementById('garage'));

ReactDOM.render(myheading, document.getElementById('heading'));
ReactDOM.render(myelement, document.getElementById('table'));