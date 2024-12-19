import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import HomePage from './App'
import Register from './Pages/signUp'
import Login from './Pages/login'
import { BrowserRouter, Routes, Route } from "react-router";
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import myRecepies from './Pages/myRecepies'
import RecepieCreation from './Pages/RecepieCreation'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<HomePage />} />
      
      <Route path="login" element={<Login />} />
      <Route path="register" element={<Register />} />
      <Route path="create" element={<RecepieCreation />} />
      <Route path="myRecepies" element={<myRecepies />} />
      
    </Routes>
    </BrowserRouter>
  </StrictMode>,
)
