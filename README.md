# Table de Rappel

Application Android d'entraînement à la mémorisation : chercher un **mot** ou un **nombre**, vérifier la réponse, et visualiser l'image associée.

## Fonctionnalités

- **Chercher un mot** — saisir un mot pour retrouver son nombre associé
- **Chercher un nombre** — saisir un nombre pour retrouver son mot associé
- **Vérifier / Solution** — réponse immédiate après saisie
- **Images** — chaque association mot ↔ nombre possède une image
- **Galerie** — parcourir l'ensemble des images

## Données

Fichiers JSON embarqués dans `app/src/main/assets/json/` :

| Fichier | Rôle |
|---|---|
| `TBNom.json` | associations nom/mot |
| `TBNombre.json` | associations nombre |

## Technique

| Élément | Valeur |
|---|---|
| Langage | Kotlin |
| UI | Views classiques (XML, RecyclerView, CardView) |
| Sérialisation | Gson |
| SDK minimum | 26 (Android 8.0) |
| SDK cible / compilation | 34 (Android 14) |
| Build | Gradle Kotlin DSL + version catalog (`gradle/libs.versions.toml`) |

## Structure

```
app/src/main/java/fr/aghi/tablederappel/
├── MainActivity.kt              # accueil + navigation basse
├── ChercherMotsActivity.kt      # mot → nombre
├── ChercherNumerosActivity.kt   # nombre → mot
├── ImagesActivity.kt            # galerie d'images
├── model/Models.kt              # modèle de données
├── utils/JsonUtils.kt           # lecture des JSON (assets)
└── ui/dashboard/                # tableau de bord (Fragment + ViewModel)
```

## Build

- Ouvrir le projet dans **Android Studio** (SDK 34 requis)
- Ou en ligne de commande :

  ```bash
  ./gradlew assembleDebug
  ```

- APK généré : `app/build/outputs/apk/debug/app-debug.apk`
