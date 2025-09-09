import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { BrowserRouter, HashRouter } from "react-router-dom";
import { AuthProvider } from "@/contexts/AuthContext";


createRoot(document.getElementById('root')).render(
  <HashRouter>
    <AuthProvider>
      <App />
    </AuthProvider>
  </HashRouter>
)
