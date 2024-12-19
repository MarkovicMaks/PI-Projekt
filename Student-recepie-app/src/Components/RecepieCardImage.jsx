
import Figure from 'react-bootstrap/Figure';

function RecepieCardImage() {
  return (
    <Figure>
      <Figure.Image
        width={300}
        height={300}
        alt="171x180"
        src="holder.js/171x180"
      />
      <Figure.Caption>
        Nulla vitae elit libero, a pharetra augue mollis interdum.
      </Figure.Caption>
    </Figure>
  );
}

export default RecepieCardImage;