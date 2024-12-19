import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import NavLink from 'react-bootstrap/esm/NavLink';


function RecepieNavbar() {
  return (
    <Navbar expand="lg" className="RecepieNavbar">
      <Container>
        <Navbar.Brand href="/"  className='TitleName'>Frugal Feast</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {/* <Nav.Link href="#link" style={{color: "#f1f4f0"}}>My recepies</Nav.Link> */}
            <Nav.Link href="/myRecepies" style={{color: "#f1f4f0"}}>My Recepies</Nav.Link>
          </Nav>
        </Navbar.Collapse>
        <Navbar.Collapse className="justify-content-end">
        <NavDropdown title="Login" style={{color: "#f1f4f0"}} id="basic-nav-dropdown">
          <NavDropdown.Item href="/login">Login</NavDropdown.Item>
          <NavDropdown.Item href="/register">Register</NavDropdown.Item>
        </NavDropdown>
          {/* <Navbar.Text style={{color: "#f1f4f0"}}>
            Signed in as: <a href="#login" style={{color: "#f1f4f0"}}>Troy Barnes</a>
          </Navbar.Text> */}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default RecepieNavbar;