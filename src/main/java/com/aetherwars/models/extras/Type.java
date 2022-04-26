package com.aetherwars.models.extras;

import com.aetherwars.enums.CharacterType;

import java.util.HashMap;

public class Type implements Comparable<Type> {
    private final CharacterType type;
    private CharacterType strong_against;
    private CharacterType weak_against;
    private static HashMap<CharacterType, Type> types;

    public Type(CharacterType type) {
        this.type = type;

        switch (type) {
            case OVERWORLD:
                this.strong_against = CharacterType.END;
                this.weak_against = CharacterType.NETHER;
                break;
            case NETHER:
                this.strong_against = CharacterType.OVERWORLD;
                this.weak_against = CharacterType.END;
                break;
            case END:
                this.strong_against = CharacterType.NETHER;
                this.weak_against = CharacterType.OVERWORLD;
                break;
        }
    }

    public CharacterType getCharacterType() {
        return type;
    }

    public HashMap<CharacterType, Type> getTypes() {
        return types;
    }

    public static Type getInstance(CharacterType type) {
        if (types == null) {
            types = new HashMap<CharacterType, Type>();
            types.put(CharacterType.OVERWORLD, new Type(CharacterType.OVERWORLD));
            types.put(CharacterType.NETHER, new Type(CharacterType.NETHER));
            types.put(CharacterType.END, new Type(CharacterType.END));
        }
        return types.get(type);
    }

    @Override
    public int compareTo(Type o) {
        if (o.type == this.strong_against) {
            return 1;
        } else if (o.type == this.weak_against) {
            return -1;
        }
        return 0;
    }
}
