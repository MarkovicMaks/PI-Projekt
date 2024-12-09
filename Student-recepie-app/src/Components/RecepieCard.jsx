import Card from 'react-bootstrap/Card';
import RecepieCardTitle from './RecepieCardTitle';
import RecepieCardDescription from './RecepieCardDescription';
import RecepieCardTags from './RecepieCardTags';
import RecepieCardImage from './RecepieCardImage';



function RecepieCard() {
  return (
    <a>
      <Card className='RecepieCard'>
      <Card.Body>
        <div className='RecepieCardTop'>
        <RecepieCardTitle />
        <RecepieCardTags />
        </div>
        <div className='RecepieCardBot'>
        <RecepieCardDescription />
        <RecepieCardImage />
        </div>
      </Card.Body>
    </Card>
    </a>
  );
}

export default RecepieCard;