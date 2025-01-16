import Card from "react-bootstrap/Card";
import RecepieCardTitle from "./RecepieCardTitle";
import RecepieCardDescription from "./RecepieCardDescription";
import RecepieCardTags from "./RecepieCardTags";

function RecepieCard({
  title,
  description,
  priceTag,
  healthTag,
  preferenceTag,
}) {
  return (
    <a>
      <Card className="RecepieCard">
        <Card.Body>
          <div className="RecepieCardTop">
            <RecepieCardTitle title={title} />
            <RecepieCardTags
              priceTag={priceTag}
              healthTag={healthTag}
              preferenceTag={preferenceTag}
            />
          </div>
          <div className="RecepieCardBot">
            <RecepieCardDescription title={description}/>
          </div>
        </Card.Body>
      </Card>
    </a>
  );
}

export default RecepieCard;
