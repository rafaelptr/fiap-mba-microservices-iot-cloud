FROM node:11.8-alpine

ENV TOPICO=meu-topico
ENV HOST=0.0.0.0
ENV PORTA=9092
ENV SLACK=inserir-webhook
ENV CANAL=lab-consumidor
#exemplo: ENV CANAL=lab-testes
ENV SLACK=https://hooks.slack.com/services/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

WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .

CMD [ "npm", "start" ]
