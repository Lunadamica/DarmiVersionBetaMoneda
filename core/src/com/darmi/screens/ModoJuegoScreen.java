package com.darmi.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class ModoJuegoScreen extends BaseScreen{
    private Stage stage;
    private Skin skin;
    private Label titulo;
    private TextButton back,tiempo,puntos;

    public ModoJuegoScreen(final MainGame game) {
        super(game);
        //definimos el stage
        stage = new Stage(new FitViewport(640, 360));
        //instanciamos las skins
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        //Instanciamos los botones
        back = new TextButton("Volver", skin);
        tiempo = new TextButton("Tiempo", skin);
        puntos = new TextButton("Puntos", skin);

        //Instanciamos una label que explicara el objetivo del juego y menciona los creadores
        titulo = new Label("Modo de Juego", skin);

        //Definimos un boton para volver a la pantalla de menu
        back.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.menuScreen);
            }
        });
        //Definimos un boton para volver a la pantalla de menu
        tiempo.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.seleccionScreen);
            }
        });
        //Definimos un boton para volver a la pantalla de menu
        puntos.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.seleccionScreenPuntos);
            }
        });

        //Asignamos tamaño y posicion a nuestros elementos que cargaremos en la pantalla
        titulo.setPosition(20, 340 - titulo.getHeight());
        back.setSize(100, 100);
        back.setPosition(40, 50);
        tiempo.setSize(100, 100);
        tiempo.setPosition(100, 50);
        puntos.setSize(100, 100);
        puntos.setPosition(200, 50);

        //Añadimos todos estos recursos como actores del stage
        stage.addActor(tiempo);
        stage.addActor(puntos);
        stage.addActor(back);
        stage.addActor(titulo);
    }

    @Override
    public void show() {
        //Se ejecuta solo cuando se inicia la pantalla
        //Procesa todos los procesos del stage
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        //Cuando cerramos la pantalla ponemos a null este InputProcessor
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        //eliminamos el stage y las skin
        stage.dispose();
        skin.dispose();
    }

    @Override
    public void render(float delta) {
        //pintamos el fondo de negro
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Actualizamos y pintamos el stage
        stage.act();
        stage.draw();
    }
}
