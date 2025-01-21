import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import '@testing-library/jest-dom';
import App from './App';
import HomePage from './App'; // Replace with correct path if different
import Login from './Pages/login'; // Replace with correct path if different
import Register from './Pages/signUp'; // Replace with correct path if different
import RecepieCreation from './Pages/RecepieCreation'; 
import Myrecepie from './Pages/myRecepies'; 

test('renders home page at default route', () => {
  render(
    <BrowserRouter>
      <App />
    </BrowserRouter>
  );
  expect(screen.getByText(/home/i)).toBeInTheDocument(); 
});

test('renders login page at /login', () => {
  render(
    <BrowserRouter initialEntries={['/login']}>
      <Login />
    </BrowserRouter>
  );
  expect(screen.getByText(/login/i)).toBeInTheDocument(); // Replace with unique text/content in Login
});

test('renders register page at /register', () => {
  render(
    <BrowserRouter initialEntries={['/register']}>
      <Register />
    </BrowserRouter>
  );
  expect(screen.getByText(/register/i)).toBeInTheDocument(); // Replace with unique text/content in Register
});

test('renders recipe creation page at /create', () => {
  render(
    <BrowserRouter initialEntries={['/create']}>
      <RecepieCreation />
    </BrowserRouter>
  );
  expect(screen.getByText(/create/i)).toBeInTheDocument(); // Replace with unique text/content in RecepieCreation
});

test('renders my recipes page at /myrecepie', () => {
  render(
    <BrowserRouter initialEntries={['/myrecepie']}>
      <Myrecepie />
    </BrowserRouter>
  );
  expect(screen.getByText(/my recipes/i)).toBeInTheDocument(); // Replace with unique text/content in Myrecepie
});
